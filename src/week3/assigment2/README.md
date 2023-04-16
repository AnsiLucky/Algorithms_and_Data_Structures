![AITU](https://static.tildacdn.com/tild3764-6633-4663-b138-303730646233/aitu-logo__2.png)
# _Assignment-2 of **ADS** course_
## **_Shaumen Angsar_** (*SE-2202*) 🇰🇿

### MyList (Interface)
- ```size()```- int, return length of list.
- ```contains(Object o)```- boolean, return true if item is in list.
- ```add(T item)```- void, add element to list.
- ```add(T item, int index)```- void, add element at specific index.
- ```remove(T item)```- boolean, return true if removed.
- ```remove(int index)```- object, return removed object, otherwise throw exception.
- ```clear()```- void, clear list.
- ```get(int index)```- object, return element at given index.
- ```indexOf(Object o)```- int, return the first index of item in list.
- ```lastIndexOf(Object o)```- int, return the last index of item in list.
- ```sort()```- void, sort list by ASC.
### MyArrayList (Class)
- ```increaseBuffer()```- void, increase capacity of list by 2 times.
- ```swap(Object[] arr, int i, int j)```- void, swap two Objects in list.
- implements MyList (Interface).
- List is iterable using Iterable.
### MyLinkedList (Class)
- ```removeNode(MyNode node)```- void, remove the specified node.
- List is iterable using Iterable.
### Main (Class)
- test all methods from MyArrayList and MyLinkedList with <Integer> and <String> data structures.


