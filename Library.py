# Framework: N/A
# Technology Stack: N/A

class Library:
    books_list = []
    users_list = []
    books_sell = []

    def get_books_list(self):
        return self.books_list

    def get_users_list(self):
        return self.users_list

    def get_books_sell(self):
        return self.books_sell

    def add_book(self, book):
        self.books_list.append(book)

    def add_user(self, user):
        self.users_list.append(user)

    def add_sell_book(self, sell_book):
        self.books_sell.append(sell_book)