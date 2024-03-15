class Library:
    booksList = []
    usersList = []
    booksSell = []

    @classmethod
    def get_books(cls):
        return cls.booksList

    @classmethod
    def get_users(cls):
        return cls.usersList

    @classmethod
    def get_sell_books(cls):
        return cls.booksSell

    @classmethod
    def add_book(cls, book):
        cls.booksList.append(book)

    @classmethod
    def add_user(cls, user):
        cls.usersList.append(user)

    @classmethod
    def add_sell_book(cls, sell_book):
        cls.booksSell.append(sell_book)