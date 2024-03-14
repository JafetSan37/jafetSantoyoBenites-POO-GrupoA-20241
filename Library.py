class Library:
    books_list = []
    users_list = []
    books_sell = []
    
    @staticmethod
    def get_books_list():
        return Library.books_list
    
    @staticmethod
    def get_users_list():
        return Library.users_list
    
    @staticmethod
    def get_books_sell():
        return Library.books_sell
    
    @staticmethod
    def add_book(book):
        Library.books_list.append(book)
    
    @staticmethod
    def add_user(user):
        Library.users_list.append(user)
    
    @staticmethod
    def add_sell_book(sell_book):
        Library.books_sell.append(sell_book)