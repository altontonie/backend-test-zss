# backend-test-zss

I made the assumption that when purchasing a book, a customer would provide their bank card and their card number would be capture hence to only provide card number for the purpose of this test.
purchase request Object:
{
  "id": "string"
}

# Use the following format when creating a book:
{
  "book": {
    "description": "string",
    "price": 0,
    "title": "string"
  },
  "categoryTitle": "string"
}

# for adding a category:
{
  "categoryTitle": "string"
}

# Updating a Book
you can change all the details of the book
{
  "book": {
    "description": "string",
    "price": 0,
    "title": "string"
  },
  "categoryTitle": "string"
}
