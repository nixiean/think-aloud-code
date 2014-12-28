/*
* Class containing the implentation of Hashtable
*/

public class Hashmap_imp
{
	//Size of the hash table
	int hashSize = 10;
	hashEntry[] hashTable;

	/* Constructor
	 * Initialize hash table with null
	*/
	public Hashmap_imp()
	{
		
		hashTable = new hashEntry[hashSize];
		for (int i = 0; i < hashSize; i++) 
			hashTable[i] = null;
	}

	/* 
	 * Returns the hashvalue of the given string
	*/
	public int hashKey(String key) {
		int hashValue = 0;
		for (int i = 0; i < key.length();i++)
			hashValue = hashValue + key.charAt(i);
		hashValue = hashValue % hashSize;
		return hashValue;
	}


	/* 
	 * Inserts a new key, value pair to the hashtable with collision handling
	*/
	public void hashPut(String key, int value) {
		int hashValue = hashKey(key); 
		if(hashTable[hashValue] != null) {
			//Check for collision 
			if (hashTable[hashValue].getKey() != key) {
				System.out.println("Collision while inserting the key \'" + key + "\'");
				hashEntry hashTraverser = hashTable[hashValue];
				//Traverse till the next null entry 
				while( hashTraverser.next != null) 
					hashTraverser = hashTraverser.next;
				//New key-value inserted in the linked list.
				hashTraverser.next = new hashEntry(key,value);
			}
			else
				//Update the value for the key 
				hashTable[hashValue] = new hashEntry(key,value);
		}
		else
			//New key-value inserted. 
			hashTable[hashValue] = new hashEntry(key,value);
	}

	/*
	* Returns the value for a given key
	*/
	public int hashGet(String key) {
		int hashValue = hashKey(key);
		if (hashTable[hashValue] != null) {
			if (hashTable[hashValue].getKey() == key)
				return  hashTable[hashValue].getValue();
			else {
				hashEntry hashTraverser = hashTable[hashValue].next;	
				while( hashTraverser != null ) {
					if (hashTraverser.getKey() == key)
						return hashTraverser.getValue();
					else
						hashTraverser = hashTraverser.next;
				}
				return -1;
			}
		}
		else 
			return -1;
	}

	/*
	* Driver program to test the hash table implementation 
	*/
	public static void main(String[] args)
	{
		Hashmap_imp  hTable = new Hashmap_imp();
		
		String []hashTest = { "one" , "two" , "three" , "four" , "five" };
		int count = 1;
		//Insert key-value pairs
		for ( String s : hashTest) 
			hTable.hashPut(s, count++);
		
		//Get the value from the keys
		for ( String s : hashTest) 
			System.out.println("Key-> " + s + " - Value-> " +hTable.hashGet(s));
	}	
}

/*
* Class which holds the key-value-next elements for hash table implementation.
*/
class hashEntry{
	String key;
	int value;
	hashEntry next;

	/* Constructor
	* Insert the key-value combination 
	*/
	public hashEntry(String key, int value) {
		this.key = key;
		this.value = value;
		next = null;
	}

	/*
	* Returns the key 
	*/
	public String getKey() {
		return key;
	}

	/* 
	* Returns the value 
	*/
	public int getValue() {
		return value;
	}
}