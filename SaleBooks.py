class SaleBooks:
    def __init__(self, ID, title, author, year, price, inventory):
        self.ID = ID
        self.title = title
        self.author = author
        self.year = year
        self.price = price
        self.inventory = inventory
        self.available = True

    def get_id(self):
        return self.ID

    def get_title(self):
        return self.title

    def set_title(self, title):
        self.title = title

    def get_author(self):
        return self.author

    def set_author(self, author):
        self.author = author

    def get_year(self):
        return self.year

    def set_year(self, year):
        self.year = year

    def get_inventory(self):
        return self.inventory

    def set_inventory(self, inventory):
        self.inventory = inventory

    def get_price(self):
        return self.price

    def set_price(self, price):
        self.price = price

    def is_available(self):
        return self.available

    def set_available(self, available):
        self.available = available