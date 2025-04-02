package com.example.authenticationn.ui.Data.Domain

import BillingAndPaymentManager
import com.example.authenticationn.ui.Data.Database.Models.Analytics
import com.example.authenticationn.ui.Data.Database.Models.Bill
import com.example.authenticationn.ui.Data.Database.Models.Order
import com.example.authenticationn.ui.Data.Database.Models.Payment
import com.example.authenticationn.ui.Data.Database.Models.User
import com.example.authenticationn.ui.Data.Database.managers.AnalyticsManager
import com.example.authenticationn.ui.Data.Database.managers.CanesManager
import com.example.authenticationn.ui.Data.Database.managers.OrderManager
import com.example.authenticationn.ui.Data.Database.managers.UserManager




  class FireBaseRepository(

    ){
    val  analyticsManager: AnalyticsManager=AnalyticsManager()
    val  BillingAndPaymentManager= BillingAndPaymentManager()
   val   UserManager =UserManager()
   val  CanesManager= CanesManager()
     val OrderManager=OrderManager()



//   user manager
     suspend fun signUp(user: User, password: String): Result<String> {
         return UserManager.signUp(user, password)
     }
     suspend fun signIn(email: String, password: String): Result<String> {
         return UserManager.login(email, password)
     }
     suspend fun getUser(userId: String): Result<User> {
         return UserManager.getUser(userId)
     }
     suspend fun updateUser(user: User): Result<Unit> {
         return UserManager.updateUser(user)
     }
     suspend fun addCustomer(user: User, password: String): Result<String> {
         return UserManager.addCustomer(user, password)
     }
     suspend fun deleteUser(userId: String): Result<Unit> {
         return UserManager.deleteUser(userId)
     }
     suspend fun getAllUsers(): Result<List<User>> {
         return UserManager.getAllUsers()
     }




// Order manager
     suspend fun  createOrder(order: Order): Result<String> {
         return OrderManager.createOrder(order)
     }
     suspend fun getOrder(orderId: String): Result<Order> {
         return OrderManager.getOrder(orderId)
     }
     suspend fun updateOrderStatus(orderId: String, newStatus: String): Result<Unit> {
         return OrderManager.updateOrderStatus(orderId, newStatus)
     }
     suspend fun updateOrder(order: Order): Result<Unit> {
         return OrderManager.updateOrder(order)
     }
     suspend fun deleteOrder(orderId: String): Result<Unit> {
         return OrderManager.deleteOrder(orderId)
     }
     suspend fun getAllOrders(): Result<List<Order>> {
         return OrderManager.getAllOrders()
     }
     suspend fun getAllTodayOrders(): Result<List<Order>> {
         return OrderManager.getAllTodayOrders()
     }


     // Bill manager


     suspend fun createBill(bill: Bill): Result<String> {
         return BillingAndPaymentManager.createBill(bill)
     }

     suspend fun markBillAsPaid(billId: String): Result<Unit> {
         return BillingAndPaymentManager.markBillAsPaid(billId)
     }
     suspend fun updateBill(bill: Bill): Result<Unit> {
         return BillingAndPaymentManager.updateBill(bill)
     }
     suspend fun getBill(billId: String): Result<Bill> {
         return BillingAndPaymentManager.getBill(billId)
     }
     suspend fun getAllBills(): Result<List<Bill>> {
         return BillingAndPaymentManager.getAllBills()
     }
     suspend fun recordPayment(payment: Payment): Result<String> {
         return BillingAndPaymentManager.recordPayment(payment)
     }
     suspend fun getAllPayments(): Result<List<Payment>> {
         return BillingAndPaymentManager.getAllPayments()
     }

     /// Analytics manager

     suspend fun getAnalytics(analyticsId: String): Result<Analytics> {
          return analyticsManager.getAnalytics(analyticsId)
     }

     suspend fun updateAnalytics(analytics: Analytics): Result<Unit> {
          return analyticsManager.updateAnalytics(analytics)
     }

/// canes manager
     suspend fun updateCanesReturned(userId: String, canesReturned: Int): Result<Unit> {
          return CanesManager.updateCanesReturned(userId, canesReturned)
     }
     suspend fun updateCanesTaken(userId: String, canesTaken: Int): Result<Unit> {
          return CanesManager.updateCanesTaken(userId, canesTaken)
     }








}


