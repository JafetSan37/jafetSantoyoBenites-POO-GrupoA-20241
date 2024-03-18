class Bank:
    employee_list = []
    accounts_list = []

    @classmethod
    def get_employee_list():
        return Bank.employee_list

    @classmethod
    def get_accounts_list():
        return Bank.accounts_list

    @classmethod
    def add_employee(employee):
        Bank.employee_list.append(employee)

    @classmethod
    def add_accounts_list(account):
        Bank.accounts_list.append(account)