package ordermanagement;

import java.util.Scanner;

public class OrderManagement {
    public static void main(String[] args) {
        try {
            String userChoice = "Z",sLoopCounter=" ";
            String userToUpdate="00",lowestSellPriceOID="00",highestBuyPriceOID="00";
            int intuserToUpdate=0,intuserToUpdate2nd=0;
            int lowestSellPrice=0,executedQty=0; 
            int highestBuyPrice=0;
// User Detail Data
            String[] UserDtlID = new String[20];
            String[] UserDtlName = new String[20];
            Integer[] UserDtlTotalCoins = new Integer[20];
            Integer[] UserDtlTotalINR = new Integer[20];
// Order Book Data
            String[] orderDtlID = new String[100];
            String[] orderDtlUserID = new String[100];
            String[] orderDtlType = new String[100];
            Integer[] orderDtlPrice = new Integer[100];
            Integer[] orderDtlQuantity = new Integer[100];
            String[] orderDtlExStatus = new String[100];
            Integer[] orderDtlQtyExecuted = new Integer[100];
// Detail of Transaction Log
            String[] trxnDtlID = new String[100];
            String[] trxnDtlOrderIDBUY = new String[100];
            String[] trxnDtlOrderIDSELL = new String[100];
            String[] trxnDtlUserIDBUY = new String[100];
            String[] trxnDtlUserIDSELL = new String[100];
            Integer[] trxnDtlRateOfEx = new Integer[100];
            Integer[] trxnDtlQtyExecuted = new Integer[100];
            Integer[] trxnDtlTrxnValue = new Integer[100];
// Detail of Transaction Log
            int totalOrders=0,totalUsers=0,loopCounter=0,totalTrxn=0;
            while (userChoice.equals("Z")) {
                   System.out.println("List of Existing User with their Coin & INR Values (Balances)");
                   System.out.println("=============================================================");
                   System.out.println("User ID : User Name  : Total Coins : Total INR");
                   loopCounter=0;
                   while (loopCounter<totalUsers) {
                          System.out.println(UserDtlID[loopCounter]+"        "+UserDtlName[loopCounter]+UserDtlTotalCoins[loopCounter]+"          "+UserDtlTotalINR[loopCounter]);
                          loopCounter++;
                   } // Display list of all users
                   System.out.println("=============================================================");
                   System.out.println("Current Order Book");
                   System.out.println("========================================================================================================================");
                   System.out.println("Order ID : User ID : Type of Order : Price    : Quantity (Coins)  : Execution Status               : Executed Quantity");
                   loopCounter=0;
                   while (loopCounter<totalOrders){
                          System.out.println(orderDtlID[loopCounter]+"         "+orderDtlUserID[loopCounter]+"           "+orderDtlType[loopCounter]+"              "+orderDtlPrice[loopCounter]+"        "+orderDtlQuantity[loopCounter]+"            "+orderDtlExStatus[loopCounter]+"   "+orderDtlQtyExecuted[loopCounter]);
                          loopCounter++;
                   } // Display list of all orders in order book
                   System.out.println("List of all the Transactions");
                   System.out.println("========================================================================================================================");
                   System.out.println("Trxn. ID: Order ID BUY : Order ID SELL : User ID BUY : User ID SELL :Rate of Execution : Qty. of Execution: Trxn. Value ");
                   loopCounter=0;
                   while (loopCounter<totalTrxn){
                          System.out.println(trxnDtlID[loopCounter]+"        "+trxnDtlOrderIDBUY[loopCounter]+"             "+trxnDtlOrderIDSELL[loopCounter]+"              "+trxnDtlUserIDBUY[loopCounter]+"            "+trxnDtlUserIDSELL[loopCounter]+"            "+trxnDtlRateOfEx[loopCounter]+"                   "+trxnDtlQtyExecuted[loopCounter]+"               "+trxnDtlTrxnValue[loopCounter]);
                          loopCounter++;
                   } // Display list of all the Transactions
                   System.out.println("=====================================================");
                   System.out.println("Order Management System : Buying and Selling of Coins");
                   System.out.println("=====================================================");
                   System.out.println("A : Add New User in the List");
                   System.out.println("B : Update User Detail");
                   System.out.println("C : Delete User Detail");
                   System.out.println("D : Add New Buying Order");
                   System.out.println("E : Add New Selling Order");
                   System.out.println("F : Cancel All Existing Orders for all users");
                   System.out.println("G : Cancel All Orders of a particular User");
                   System.out.println("H : Cancel particular order from order book");
                   System.out.println("I : Execute particular Order");
                   System.out.println("J : Get Lowest available Sell price");
                   System.out.println("K : Get Highest available Buy price");
                   System.out.println("X : Exit Order Management System");
                   Scanner sc=new Scanner(System.in);
                   System.out.println("Enter your Choice (A-K or X : ");
                   userChoice=sc.nextLine(); userChoice= userChoice.trim(); userChoice= userChoice.toUpperCase();
//                   sc.close();
                   if (userChoice.equals("X")) {
                       break;
                   }
// Add new User in the user list
                   if (userChoice.equals("A")) {
                       loopCounter=totalUsers;
                       System.out.println("Enter user Name : ");
                       UserDtlName[loopCounter]=sc.nextLine();
                       if (UserDtlName[loopCounter].length()<13) {
                           int noOfSpaces=13-UserDtlName[loopCounter].length();
                           UserDtlName[loopCounter] = UserDtlName[loopCounter].trim()+rightPadding(" ", noOfSpaces);
                       }
                       System.out.println("Enter Total Coins for "+UserDtlName[loopCounter]+" : ");
                       UserDtlTotalCoins[loopCounter]=sc.nextInt();
                       System.out.println("Enter Total INR for "+UserDtlName[loopCounter]+" : ");
                       UserDtlTotalINR[loopCounter]=sc.nextInt();
                       if (totalUsers<9) {
                           sLoopCounter = Integer.toString(totalUsers+1);
                           UserDtlID[loopCounter] = "0"+sLoopCounter;
                       }
                       else {
                           sLoopCounter = Integer.toString(totalUsers+1);
                           UserDtlID[loopCounter] = sLoopCounter;
                       }
                       totalUsers++;
                   }
// Add new User in the user list
// Update data for User in the user list
                   if (userChoice.equals("B")) {
                       System.out.println("Enter user ID to update : ");
                       userToUpdate =sc.nextLine();
                       intuserToUpdate = Integer.valueOf(userToUpdate)-1;
                       System.out.println("Enter updated name for : "+UserDtlName[intuserToUpdate]);
                       UserDtlName[intuserToUpdate]=sc.nextLine();
                       if (UserDtlName[intuserToUpdate].length()<13) {
                           int noOfSpaces=13-UserDtlName[intuserToUpdate].length();
                           UserDtlName[intuserToUpdate] = UserDtlName[intuserToUpdate].trim()+rightPadding(" ", noOfSpaces);
                       }
                       System.out.println("Enter Total Coins for "+UserDtlName[intuserToUpdate]+" : ");
                       UserDtlTotalCoins[intuserToUpdate]=sc.nextInt();
                       System.out.println("Enter Total INR for "+UserDtlName[intuserToUpdate]+" : ");
                       UserDtlTotalINR[intuserToUpdate]=sc.nextInt();
                   }
// Update data for User in the user list
// Delete data for User in the user list
                   if (userChoice.equals("C")) {
                       System.out.println("Enter user ID to delete : ");
                       userToUpdate =sc.nextLine();
                       intuserToUpdate = Integer.valueOf(userToUpdate)-1;
                       UserDtlName[intuserToUpdate]="Deleted";
                       if (UserDtlName[intuserToUpdate].length()<13) {
                           int noOfSpaces=13-UserDtlName[intuserToUpdate].length();
                           UserDtlName[intuserToUpdate] = UserDtlName[intuserToUpdate].trim()+rightPadding(" ", noOfSpaces);
                       }
                       UserDtlTotalCoins[intuserToUpdate]=0;
                       UserDtlTotalINR[intuserToUpdate]=0;
                   }
// Delete data for User in the user list
// Add new Buying Order in Order Book for a particular user.
                   if (userChoice.equals("D")) {
                       loopCounter = totalOrders;
                       System.out.println("Enter user ID to place Buying Order : ");
                       userToUpdate =sc.nextLine();
                       intuserToUpdate = Integer.valueOf(userToUpdate)-1;
                       if (Integer.valueOf(userToUpdate)>totalUsers || Integer.valueOf(userToUpdate)<1 || UserDtlTotalINR[intuserToUpdate]==0) {
                           System.out.println("Invalid user ID / Insufficient Fund");
                       }
                       else {
                           orderDtlExStatus[loopCounter] = " ";
                           orderDtlQtyExecuted[loopCounter] = 0;
                           orderDtlUserID[loopCounter]=userToUpdate;
                           orderDtlType[loopCounter]="BUY";
                           System.out.println("Enter Price for Buying order for User ID : "+userToUpdate+" Name : "+UserDtlName[intuserToUpdate]+" : ");
                           orderDtlPrice[loopCounter]=sc.nextInt();
                           System.out.println("Enter Quantity for Buying order for User ID : "+userToUpdate+" Name : "+UserDtlName[intuserToUpdate]+" : ");
                           orderDtlQuantity[loopCounter]=sc.nextInt();
                           if (totalOrders<9) {
                               sLoopCounter = Integer.toString(totalOrders+1);
                               orderDtlID[loopCounter] = "0"+sLoopCounter;
                           }
                           else {
                               sLoopCounter = Integer.toString(totalOrders+1);
                               orderDtlID[loopCounter] = sLoopCounter;
                           }
                           totalOrders++;
                       }
                   }
// Add new Buying Order in Order Book for a particular user.
// Add new Selling Order in Order Book for a particular user.
                   if (userChoice.equals("E")) {
                       loopCounter = totalOrders;
                       System.out.println("Enter user ID to place Selling Order : ");
                       userToUpdate =sc.nextLine();
                       intuserToUpdate = Integer.valueOf(userToUpdate)-1;
                       if (Integer.valueOf(userToUpdate)>totalUsers || Integer.valueOf(userToUpdate)<1 || UserDtlTotalCoins[intuserToUpdate]==0) {
                           System.out.println("Invalid user ID / Insufficient coin");
                       }
                       else {
                           orderDtlExStatus[loopCounter] = " ";
                           orderDtlQtyExecuted[loopCounter] = 0;
                           orderDtlUserID[loopCounter]=userToUpdate;
                           orderDtlType[loopCounter]="SELL";
                           System.out.println("Enter Price for Selling order for User ID : "+userToUpdate+" Name : "+UserDtlName[intuserToUpdate]+" : ");
                           orderDtlPrice[loopCounter]=sc.nextInt();
                           System.out.println("Enter Quantity for Selling order for User ID : "+userToUpdate+" Name : "+UserDtlName[intuserToUpdate]+" : ");
                           orderDtlQuantity[loopCounter]=sc.nextInt();
                           if (totalOrders<9) {
                               sLoopCounter = Integer.toString(totalOrders+1);
                               orderDtlID[loopCounter] = "0"+sLoopCounter;
                           }
                           else {
                               sLoopCounter = Integer.toString(totalOrders+1);
                               orderDtlID[loopCounter] = sLoopCounter;
                           }
                           totalOrders++;
                       }
                   }
// Add new Selling Order in Order Book for a particular user.
// Cancel all the orders in Order Book.
                   if (userChoice.equals("F")) {
                       System.out.println("Do you want to cancell all the orders in order book (Y/N) ? ");
                       String userResponse = sc.nextLine(); userResponse = userResponse.toUpperCase();
                       if (userResponse.equals("Y")) {
                           loopCounter=0;
                           while (loopCounter<totalOrders){
                                  orderDtlType[loopCounter]="CAN";
                                  orderDtlPrice[loopCounter]=0;
                                  orderDtlQuantity[loopCounter]=0;
                                  loopCounter++;
                           } // Cancel all the orders in Order Book.
                       }
                   }
// Cancel all the orders in Order Book.
// Cancel all the orders of a particular user.
                   if (userChoice.equals("G")) {
                       System.out.println("Enter user ID to cancel all the orders of that user : ");
                       String userResponse = sc.nextLine(); userResponse = userResponse.trim();
                       loopCounter=0;
                       while (loopCounter<totalOrders){
                              if (userResponse.equals(orderDtlUserID[loopCounter]) && (orderDtlType[loopCounter].equals("BUY") || orderDtlType[loopCounter].equals("SELL"))) {
                                  orderDtlType[loopCounter]="CAN";
                                  orderDtlPrice[loopCounter]=0;
                                  orderDtlQuantity[loopCounter]=0;
                              }
                              loopCounter++;
                       } // Cancel all the orders in Order Book.
                   }
// Cancel all the orders of a particular user.
// Cancel particular order from order book
                   if (userChoice.equals("H")) {
                       System.out.println("Enter Order ID to cancel : ");
                       String userResponse = sc.nextLine(); userResponse = userResponse.trim();
                       loopCounter=0;
                       while (loopCounter<totalOrders){
                              if (userResponse.equals(orderDtlID[loopCounter]) && (orderDtlType[loopCounter].equals("BUY") || orderDtlType[loopCounter].equals("SELL"))) {
                                  orderDtlType[loopCounter]="CAN";
                                  orderDtlPrice[loopCounter]=0;
                                  orderDtlQuantity[loopCounter]=0;
                              }
                              loopCounter++;
                       } // Cancel all the orders in Order Book.
                   }
// Cancel particular order from order book
// Execute particular order from order book
                   if (userChoice.equals("I")) {
                       System.out.println("Enter Order ID to execute : ");
                       String userResponse = sc.nextLine(); userResponse = userResponse.trim();
                       loopCounter=0; String userOfCurOrder = " ";
                       while (loopCounter<totalOrders){
                              if (userResponse.equals(orderDtlID[loopCounter]) && (orderDtlType[loopCounter].equals("BUY") || orderDtlType[loopCounter].equals("SELL"))) {
// Search proper match to execute the order.
                                  userOfCurOrder = orderDtlUserID[loopCounter];
                                  int loopCounterInner=0; String matchingType = " ",ExPartFullBuyer="Fully ",ExPartFullSeller="Fully ";
                                  int priceOfCurOrder = orderDtlPrice[loopCounter]; int totalBuyingValue=0,balQtyBuyer=0,balQtySeller=0,effectiveQtyEx=0;
                                  int balQtyForSelling=0,balQtyForBuying=0;
                                  int quantityOfCurOrder = orderDtlQuantity[loopCounter];
                                  int quantityOfExOrder = orderDtlQtyExecuted[loopCounter];
                                  intuserToUpdate = Integer.valueOf(userOfCurOrder)-1;
                                  if (orderDtlType[loopCounter].equals("BUY"))  {
                                      matchingType = "SELL";
                                      totalBuyingValue = (priceOfCurOrder*(quantityOfCurOrder-quantityOfExOrder));
                                      if (totalBuyingValue>UserDtlTotalINR[intuserToUpdate]) {
// Insufficient fund in user account to buy.
                                          break;
                                      }
                                  }
                                  if (orderDtlType[loopCounter].equals("SELL"))  {
                                      matchingType = "BUY";
                                      int totalSellQty = (quantityOfCurOrder-quantityOfExOrder);
                                      if (totalSellQty>UserDtlTotalCoins[intuserToUpdate]) {
// Insufficient number of coins in user account.
                                          break;
                                      }
                                  }
// Find lowest Sell / Highest Buy order IDs to execute above mentioned order.
                                  loopCounterInner = 0; lowestSellPriceOID="00";highestBuyPriceOID="00";lowestSellPrice=0;highestBuyPrice=0;
                                  while (loopCounterInner<totalOrders){
                                         if (orderDtlType[loopCounterInner].equals("SELL"))  {
                                                      if (lowestSellPrice==0 || (orderDtlPrice[loopCounterInner]<lowestSellPrice)) {
                                                          balQtyForSelling = (orderDtlQuantity[loopCounterInner]-orderDtlQtyExecuted[loopCounterInner]);
                                                          if (balQtyForSelling>0) {
                                                              lowestSellPrice = orderDtlPrice[loopCounterInner];
                                                              lowestSellPriceOID = orderDtlID[loopCounterInner];
                                                          }
                                                      }
                                         } // Execution of Buying Orders
                                         else {
                                                if (orderDtlType[loopCounterInner].equals("BUY"))  {
                                                      if (highestBuyPrice==0 || (orderDtlPrice[loopCounterInner]>highestBuyPrice)) {
                                                          balQtyForBuying = (orderDtlQuantity[loopCounterInner]-orderDtlQtyExecuted[loopCounterInner]);
                                                          if (balQtyForBuying>0) {
                                                              highestBuyPrice = orderDtlPrice[loopCounterInner];
                                                              highestBuyPriceOID = orderDtlID[loopCounterInner];
                                                          }
                                                      }
                                                } // Execution of Selling Orders
                                         }
                                         loopCounterInner++;
                                  } // order execution inner loop
// Find lowest Sell / Highest Buy order IDs to execute above mentioned order.
                                  System.out.println("======= Lowest Sell Price Order ID : "+lowestSellPriceOID);
                                  System.out.println("======= Highest Buy Price Order ID : "+highestBuyPriceOID);
                                  if (lowestSellPriceOID.equals("00") && matchingType.equals("SELL")) {
                                      break;
                                  }
                                  if (highestBuyPriceOID.equals("00") && matchingType.equals("BUY")) {
                                      break;
                                  }
                                  loopCounterInner = 0;
                                  while (loopCounterInner<totalOrders){
                                         if (orderDtlUserID[loopCounterInner].equals(userOfCurOrder)) {
// skip all the records of above user 
                                         }
                                         else {
                                              intuserToUpdate2nd = Integer.valueOf(orderDtlUserID[loopCounterInner])-1;
                                              if (orderDtlType[loopCounterInner].equals(matchingType))  {
                                                  if (matchingType.equals("SELL") && orderDtlID[loopCounterInner].equals(lowestSellPriceOID) && orderDtlPrice[loopCounterInner]<=priceOfCurOrder)  {
                                                            if (orderDtlQtyExecuted[loopCounter]<orderDtlQuantity[loopCounter]) {
                                                                balQtyBuyer=(orderDtlQuantity[loopCounter]-orderDtlQtyExecuted[loopCounter]);
                                                                balQtySeller=(orderDtlQuantity[loopCounterInner]-orderDtlQtyExecuted[loopCounterInner]);
                                                                if (balQtySeller>0) {
                                                                    if (balQtySeller<balQtyBuyer)  {
                                                                        ExPartFullBuyer="Partly ";ExPartFullSeller="Fully ";
                                                                        orderDtlQtyExecuted[loopCounter] = orderDtlQtyExecuted[loopCounter] + balQtySeller;
                                                                        orderDtlQtyExecuted[loopCounterInner] = orderDtlQtyExecuted[loopCounterInner] + balQtySeller;
                                                                        effectiveQtyEx = balQtySeller;
                                                                    }
                                                                    if (balQtySeller==balQtyBuyer)  {
                                                                        ExPartFullBuyer="Fully ";ExPartFullSeller="Fully ";
                                                                        orderDtlQtyExecuted[loopCounter] = orderDtlQtyExecuted[loopCounter] + balQtySeller;
                                                                        orderDtlQtyExecuted[loopCounterInner] = orderDtlQtyExecuted[loopCounterInner] + balQtySeller;
                                                                        effectiveQtyEx = balQtySeller;
                                                                    }
                                                                    if (balQtySeller>balQtyBuyer)  {
                                                                        ExPartFullBuyer="Fully ";ExPartFullSeller="Partly ";
                                                                        orderDtlQtyExecuted[loopCounter] = orderDtlQtyExecuted[loopCounter] + balQtyBuyer;
                                                                        orderDtlQtyExecuted[loopCounterInner] = orderDtlQtyExecuted[loopCounterInner] + balQtyBuyer;
                                                                        effectiveQtyEx = balQtyBuyer;
                                                                    }
                                                                    orderDtlExStatus[loopCounter] = ExPartFullBuyer+"Executed with Order ID : "+orderDtlID[loopCounterInner];
                                                                    orderDtlExStatus[loopCounterInner] = ExPartFullSeller+"Executed with Order ID : "+orderDtlID[loopCounter];
                                                                    UserDtlTotalCoins[intuserToUpdate] =  UserDtlTotalCoins[intuserToUpdate] + effectiveQtyEx;
                                                                    UserDtlTotalINR[intuserToUpdate] = UserDtlTotalINR[intuserToUpdate] - (orderDtlPrice[loopCounterInner]*effectiveQtyEx);
                                                                    UserDtlTotalCoins[intuserToUpdate2nd] =  UserDtlTotalCoins[intuserToUpdate2nd] - effectiveQtyEx;
                                                                    UserDtlTotalINR[intuserToUpdate2nd] = UserDtlTotalINR[intuserToUpdate2nd] + (orderDtlPrice[loopCounterInner]*effectiveQtyEx);
// Detail of Transaction
                                                                    if (totalTrxn<9) {
                                                                        sLoopCounter = Integer.toString(totalTrxn+1);
                                                                        trxnDtlID[totalTrxn] = "0"+sLoopCounter;
                                                                    }
                                                                    else {
                                                                        sLoopCounter = Integer.toString(totalTrxn+1);
                                                                        trxnDtlID[totalTrxn] = sLoopCounter;
                                                                    }
                                                                    trxnDtlOrderIDBUY[totalTrxn] = orderDtlID[loopCounter];
                                                                    trxnDtlOrderIDSELL[totalTrxn] = orderDtlID[loopCounterInner];
                                                                    trxnDtlUserIDBUY[totalTrxn] = orderDtlUserID[loopCounter];
                                                                    trxnDtlUserIDSELL[totalTrxn] = orderDtlUserID[loopCounterInner];
                                                                    trxnDtlRateOfEx[totalTrxn] = orderDtlPrice[loopCounterInner];
                                                                    trxnDtlQtyExecuted[totalTrxn] = effectiveQtyEx;
                                                                    trxnDtlTrxnValue[totalTrxn] = (orderDtlPrice[loopCounterInner]*effectiveQtyEx);
                                                                    totalTrxn++;
// Detail of Transaction
                                                                } // Execution of Buying Orders - Balance quantity
                                                            } // Execution of Buying Orders - Balance quantity
                                                  } // Consider all types of buying orders
                                                  if (matchingType.equals("BUY") && orderDtlID[loopCounterInner].equals(highestBuyPriceOID) && orderDtlPrice[loopCounterInner]>=priceOfCurOrder)  {
                                                            if (orderDtlQtyExecuted[loopCounter]<orderDtlQuantity[loopCounter]) {
                                                                balQtySeller=(orderDtlQuantity[loopCounter]-orderDtlQtyExecuted[loopCounter]);
                                                                balQtyBuyer=(orderDtlQuantity[loopCounterInner]-orderDtlQtyExecuted[loopCounterInner]);
                                                                if (balQtyBuyer>0) {
                                                                    if (balQtyBuyer<balQtySeller)  {
                                                                        ExPartFullBuyer="Fully ";ExPartFullSeller="Partly ";
                                                                        orderDtlQtyExecuted[loopCounter] = orderDtlQtyExecuted[loopCounter] + balQtyBuyer;
                                                                        orderDtlQtyExecuted[loopCounterInner] = orderDtlQtyExecuted[loopCounterInner] + balQtyBuyer;
                                                                        effectiveQtyEx = balQtyBuyer;
                                                                    }
                                                                    if (balQtyBuyer==balQtySeller)  {
                                                                        ExPartFullBuyer="Fully ";ExPartFullSeller="Fully ";
                                                                        orderDtlQtyExecuted[loopCounter] = orderDtlQtyExecuted[loopCounter] + balQtySeller;
                                                                        orderDtlQtyExecuted[loopCounterInner] = orderDtlQtyExecuted[loopCounterInner] + balQtySeller;
                                                                        effectiveQtyEx = balQtySeller;
                                                                    }
                                                                    if (balQtyBuyer>balQtySeller)  {
                                                                        ExPartFullBuyer="Partly ";ExPartFullSeller="Fully ";
                                                                        orderDtlQtyExecuted[loopCounter] = orderDtlQtyExecuted[loopCounter] + balQtySeller;
                                                                        orderDtlQtyExecuted[loopCounterInner] = orderDtlQtyExecuted[loopCounterInner] + balQtySeller;
                                                                        effectiveQtyEx = balQtySeller;
                                                                    }
                                                                    orderDtlExStatus[loopCounter] = ExPartFullSeller+"Executed with Order ID : "+orderDtlID[loopCounterInner];
                                                                    orderDtlExStatus[loopCounterInner] = ExPartFullBuyer+"Executed with Order ID : "+orderDtlID[loopCounter];
                                                                    UserDtlTotalCoins[intuserToUpdate] =  UserDtlTotalCoins[intuserToUpdate] - effectiveQtyEx;
                                                                    UserDtlTotalINR[intuserToUpdate] = UserDtlTotalINR[intuserToUpdate] + (orderDtlPrice[loopCounterInner]*effectiveQtyEx);
                                                                    UserDtlTotalCoins[intuserToUpdate2nd] =  UserDtlTotalCoins[intuserToUpdate2nd] + effectiveQtyEx;
                                                                    UserDtlTotalINR[intuserToUpdate2nd] = UserDtlTotalINR[intuserToUpdate2nd] - (orderDtlPrice[loopCounterInner]*effectiveQtyEx);
// Detail of Transaction
                                                                    if (totalTrxn<9) {
                                                                        sLoopCounter = Integer.toString(totalTrxn+1);
                                                                        trxnDtlID[totalTrxn] = "0"+sLoopCounter;
                                                                    }
                                                                    else {
                                                                        sLoopCounter = Integer.toString(totalTrxn+1);
                                                                        trxnDtlID[totalTrxn] = sLoopCounter;
                                                                    }
                                                                    trxnDtlOrderIDBUY[totalTrxn] = orderDtlID[loopCounterInner];
                                                                    trxnDtlOrderIDSELL[totalTrxn] = orderDtlID[loopCounter];
                                                                    trxnDtlUserIDBUY[totalTrxn] = orderDtlUserID[loopCounterInner];
                                                                    trxnDtlUserIDSELL[totalTrxn] = orderDtlUserID[loopCounter];
                                                                    trxnDtlRateOfEx[totalTrxn] = orderDtlPrice[loopCounterInner];
                                                                    trxnDtlQtyExecuted[totalTrxn] = effectiveQtyEx;
                                                                    trxnDtlTrxnValue[totalTrxn] = (orderDtlPrice[loopCounterInner]*effectiveQtyEx);
                                                                    totalTrxn++;
// Detail of Transaction
                                                                } // Execution of Selling Orders - Balance quantity
                                                             } // Execution of Selling Orders - Balance quantity
                                                  } // Consider all types of Selling orders
                                              } // Consider only relevant records of other users
                                         } // Execute Buying as well as Selling Orders
//=======================================================================================================================================================
                                         loopCounterInner++;
                                  } // order execution inner loop
                                  break;
// Search proper match to execute the order.
                              }
                              loopCounter++;
                       } // Execute particular order from order book
                   }
// Execute particular order from order book
// Find Lowest available Sell price.
                   if (userChoice.equals("J")) {
                       loopCounter=0; String curOrder = "0";
                       if (totalOrders>0) {
                           if (orderDtlType[loopCounter].equals("SELL")) {
                              lowestSellPrice = orderDtlPrice[loopCounter];
                              curOrder = orderDtlID[loopCounter];
                              executedQty = orderDtlQtyExecuted[loopCounter];
                           }
                       }
                       while (loopCounter<totalOrders){
                               if (orderDtlPrice[loopCounter] < lowestSellPrice || curOrder.equals("0")) {
                                   if (orderDtlType[loopCounter].equals("SELL")) {
                                       lowestSellPrice = orderDtlPrice[loopCounter];
                                       curOrder = orderDtlID[loopCounter];
                                       executedQty = orderDtlQtyExecuted[loopCounter];
                                   }
                              }
                              loopCounter++;
                       }
                       System.out.println("======= Lowest Sell Price ===================");
                       if (curOrder.length()<2) {
                           System.out.println("No Order found in Order Book.");
                       }
                       else {
                            System.out.println("Order ID : "+curOrder+" has Lowest Sell price of : "+lowestSellPrice+" Executed Qty.: "+executedQty);
                       }
                       System.out.println("======= Lowest Sell Price ===================");
                   } // Lowest Sell price.
// Find Highest available Buy price.
                   if (userChoice.equals("K")) {
                       loopCounter=0; String curOrder = "0";
                       if (totalOrders>0) {
                           if (orderDtlType[loopCounter].equals("BUY")) {
                              highestBuyPrice = orderDtlPrice[loopCounter];
                              curOrder = orderDtlID[loopCounter];
                              executedQty = orderDtlQtyExecuted[loopCounter];
                           }
                       }
                       while (loopCounter<totalOrders){
                               if (orderDtlPrice[loopCounter] > highestBuyPrice || curOrder.equals("0")) {
                                   if (orderDtlType[loopCounter].equals("BUY")) {
                                       highestBuyPrice = orderDtlPrice[loopCounter];
                                       curOrder = orderDtlID[loopCounter];
                                       executedQty = orderDtlQtyExecuted[loopCounter];
                                   }
                              }
                              loopCounter++;
                       }
                       System.out.println("======= Highest Buy Price ===================");
                       if (curOrder.length()<2) {
                           System.out.println("No Order found in Order Book.");
                       }
                       else {
                            System.out.println("Order ID : "+curOrder+" has Highest Buy price of : "+highestBuyPrice+" Executed Qty.: "+executedQty);
                       }
                       System.out.println("======= Highest Buy Price ===================");
                   } // Highest Buy price.
                   userChoice = "Z";
        } // end of main while loop
        } catch(Exception ex) {
            System.err.println("Error with input: " + ex.getMessage());
        }
    }
public static String rightPadding(String str, int num) {
    return String.format("%1$-" + num + "s", str);
  }
    
}
