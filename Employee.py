class Employee:
    def __init__(self, name, last_name):
        self.name = name
        self.last_name = last_name
        self.account_list = []

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_account_list(self):
        return self.account_list

    def add_account(self, account):
        self.account_list.append(account)

    def delete_account(self, account):
        self.account_list.remove(account)