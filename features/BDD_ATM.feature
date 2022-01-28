Feature: ATM features
@tag=ATM scenario BDD
	Scenario:  change the pin of the ATM card
			Given the atm card is valid
			And the account has sufficientbalance <Main Balance>
			When user inserts the card into the atm
			And user enter the pin <PIN>
			And user selects the change pin option
			And user enters the old pin <PIN>
			And user enters the new pin <New PIN>
			And user clicks on ok button
			Then PIN changed successfullymessage is displayed

Examples:
|Main Balance|New PIN|PIN|
|100|1567|1356|
|120|8756|1687|
|140|2364|2457|
	Scenario:  Check theBalance in the account usingthe atm card
			Given the atm card is valid
			And the account has sufficientbalance <Main Balance>
			When user inserts the card into the atm
			And user enter the pin <PIN>
			And user selects the display balance option
			And user selects the account type <Account Type>
			Then the Balnce in <AccountType> is displayed <MainBalance>

Examples:
|Main Balance|MainBalance|Account Type|PIN|
|100|100|Savings|1356|
|120|120|Current|1687|
|140|140|Recurring|2457|
	Scenario:  Withdraw money from account using the ATM card
			Given the atm card is valid
			And the account has sufficientbalance <Main Balance>
			When user inserts the card into the atm
			And  user enter the pin <PIN>
			And  user selects the withdraw option
			And  user selects the account type <Account Type>
			And  user enter the amount <Withdraw Amount>
			And  user clicks on ok button
			Then the amount should bedispersed from the amount
			And the balance amount shouldbe displayed <BalanceAmount>

Examples:
|Main Balance|Account Type|BalanceAmount|PIN|Withdraw Amount|
|100|Savings|80|1356|20|
|120|Current|75|1687|45|
|140|Recurring|60|2457|80|
