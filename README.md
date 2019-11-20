# 3-Android-SwitchingScreensApp
This Android project shows a way to pass parameters between activities using Intents.

If you want to pass objects between activities have a look at 3-Android-CreateYourBomb repository.

## Important:
if your activity opens a second activity and it does not wait for any upcoming values from the second activity, then use:
startActivity() method.

Otherwise use startActivityForResult() method, so your app will wait for that result, which is the case of this app.

## User Interface controls used:
    ConstraintLayout
    TextView
    TextInputLayout
    TextInputLayout for passwords with a button to see the password.
    Button
    Snackbar
    Toast
    
## MainActivity
![Screenshot_1574250375](https://user-images.githubusercontent.com/4823319/69236911-a6624e00-0be8-11ea-8c8a-1166d5c3f4dd.png)

## SecondActivity receiving a value from MainActivity
![Screenshot_1574250431](https://user-images.githubusercontent.com/4823319/69236913-a6624e00-0be8-11ea-9919-0f7a94f4c9e9.png)

## Returning to MainActivity from the SecondActivity passing a value
![Screenshot_1574250439](https://user-images.githubusercontent.com/4823319/69236915-a6fae480-0be8-11ea-8f2e-a5e2554414bc.png)
