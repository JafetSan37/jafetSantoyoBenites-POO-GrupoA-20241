class Bank:
    employee_list = []
    accounts_list = []

    @staticmethod
    def get_employee_list():
        return Bank.employee_list

    @staticmethod
    def get_accounts_list():
        return Bank.accounts_list

    @staticmethod
    def add_employee(employee):
        Bank.employee_list.append(employee)

    @staticmethod
    def add_accounts_list(account):
        Bank.accounts_list.append(account)
