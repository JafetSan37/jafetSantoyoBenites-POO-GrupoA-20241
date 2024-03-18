class BankAccount:
    def __init__(self, account_number, account_type):
        self.account_number = account_number
        self.amount = 0
        self.type = account_type

    def get_account_number(self):
        return self.account_number

    def get_amount(self):
        return self.amount

    def get_type(self):
        return self.type

    def set_type(self, account_type):
        self.type = account_type

    def set_amount(self, amount):
        if self.type == 'A':
            self._set_amount_a(amount)
        elif self.type == 'B':
            self._set_amount_b(amount)
        else:
            self.amount += amount

    def _set_amount_a(self, amount):
        if self.amount + amount <= 50000:
            self.amount += amount
        else:
            print("No puede tener más de 50,000. Su cuenta es tipo A")

    def _set_amount_b(self, amount):
        if self.amount + amount <= 100000:
            self.amount += amount
        else:
            print("No puede tener más de 100,000. Su cuenta es tipo B")

    def draw_money(self, amount):
        if self.type == 'A':
            self._draw_money_a(amount)
        elif self.type == 'B':
            self._draw_money_b(amount)
        elif self.type == 'C':
            self._draw_money_c(amount)

    def _draw_money_a(self, amount):
        if self.amount >= 1000 and self.amount - amount >= 1000:
            self.amount -= amount
        else:
            print("Error. Saldo insuficiente o límite alcanzado en la cuenta")

    def _draw_money_b(self, amount):
        if self.amount >= 5000 and self.amount - amount >= 5000:
            self.amount -= amount
        else:
            print("Error. Saldo insuficiente o límite alcanzado en la cuenta")

    def _draw_money_c(self, amount):
        if self.amount >= 10000 and self.amount - amount >= 10000:
            self.amount -= amount
        else:
            print("Error. Saldo insuficiente o límite alcanzado en la cuenta")