# Added Features 🧾

## 1. Filter Borrowed Books 📚

A new feature was added to display only the books that are currently borrowed and not returned yet.

### Implementation 👩🏻‍💻
- Added the method `findBorrowedBooks()` inside `BorrowDAO`.
- Used a JPQL query to retrieve borrow records where `status = false`.
- Added the method `borrowedBooksHandle()` inside `BorrowController`.
- The result is displayed directly in the TableView using:

```java
table.getItems().setAll(borrows);

Query Used 💫
SELECT b FROM Borrow b WHERE b.status = false

2. Search by Book ID and Student ID 🔍

A search feature was added to find a specific borrow record using both the Book ID and Student ID.

Implementation 👩🏻‍💻
Added the method searchByBookIdAndStudentId() inside BorrowDAO.
Created a JPQL query using the selected bookId and studentId.
Added the method searchbyIds() inside BorrowController.
Retrieved the selected values from the book and student ComboBoxes.
Added validation to show a warning message if no book or student is selected.
Displayed the search result directly inside the TableView.

Query Used 💫
SELECT b FROM Borrow b 
WHERE b.book.bookId = bookId 
AND b.student.studentId = studentId
