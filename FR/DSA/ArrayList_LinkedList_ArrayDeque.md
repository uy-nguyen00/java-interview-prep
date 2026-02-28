# ArrayList vs LinkedList vs ArrayDeque Cheat Sheet

| Feature | ArrayList | ArrayDeque | LinkedList |
| :--- | :--- | :--- | :--- |
| **Underlying Mechanism** | Resizable Array | Circular Resizable Array | Doubly-Linked List |
| **When to Use It (The "Best For")** | Your default choice for lists. Best when you need fast, random access to elements by their index, or when you are mostly just reading data and adding to the end of the list. | Your default choice for Stacks and Queues. Best when you only need to add, remove, or check elements at the absolute beginning or end of the collection. Highly memory efficient. | Highly specific scenarios. Best when you are heavily using a ListIterator to traverse a list and do a massive amount of inserting/deleting exactly at the cursor's current position. |
| **When to Avoid It (The "Worst For")** | Frequent insertions or deletions at the front or middle of a massive list (requires shifting elements, taking O(n) time). | When you need to access elements by a specific index (it literally doesn't support this) or when you absolutely must store null values. | Almost everything else. Do not use it for random index access. The memory overhead (creating a Node object for every item) is usually not worth it. |
| **Key Time Complexities** | Read by index: O(1)  <br/> Add to end: O(1) (amortized) <br/> Insert in middle: O(n) | Add/Remove at ends: O(1) (amortized) <br/> Get by index: N/A <br/> Insert in middle: N/A | Read by index: O(n)  <br/> Add/Remove via ListIterator: O(1) <br/> Add to ends: O(1) |
