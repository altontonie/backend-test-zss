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
You can find the id for a Book you created from the Response body

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

SWAGGER link if you wish to use Browser for better readability - http://localhost:8181/swagger-ui.html#

Project was done using Intellij
