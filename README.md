# GunlukAstroloji
In this project i tried to use okhttp in order to get data from api.
In the main actvitiy there is two spinners for selecting data as shown in images.

![a](https://user-images.githubusercontent.com/93763631/183501783-efdf6a14-3f9f-40dd-823c-b5aede0e1399.jpg)
![b](https://user-images.githubusercontent.com/93763631/183501780-4dd197e8-cb29-49a3-911d-b014717fb885.jpg)
![c](https://user-images.githubusercontent.com/93763631/183501785-d8c56d2a-dca5-4ee3-835d-bc59ce9be154.jpg)

The two spinners' items are designed with custom background which you can determine the color of text or the size instead of using default layout.

After selecting sign and day you should click "GO" button in order to get data from rapid api. Since rapid api key is uniqe for user i deleted my rapid api key. You should create a rapid api key for using that api. After that you should add your api key go to MainActivity and find the place which contains "YOUR-RAPİD-APİ-KEY" and type your api key there.

There is also an intent for starting result activity. Also i used putExtra method in order to transfer the data which i get from rapid api to result activity.
There is there textViews inside scrollView because most probably the size of data that we get will be huge for screen size.
![d](https://user-images.githubusercontent.com/93763631/183503487-259563a0-b2b6-4fdb-bc35-3b6b68888351.jpg)
![e](https://user-images.githubusercontent.com/93763631/183503495-f9b8fd2b-3cd7-463c-93cc-291ee9486166.jpg)

In the result acitivty there is a method which parses data to textViews. There is a easy way to parse data if the data is in Json format.
I used JSONObject class in order to parse data from json to readeable result.
The project is too simple but there is a lot of thing that i learned and i practiced many things. 
