package com.example.authenticationn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticationn.ui.Data.Database.Models.Analytics
import com.example.authenticationn.ui.Data.Database.Models.Bill
import com.example.authenticationn.ui.Data.Database.Models.Order
import com.example.authenticationn.ui.Data.Database.Models.Payment
import com.example.authenticationn.ui.Data.Database.Models.User
import com.example.authenticationn.ui.Data.Domain.FireBaseRepository
import kotlinx.coroutines.launch

class FireBaseViewModel() : ViewModel() {
    private val repository= FireBaseRepository()
    // User-related functions
    fun signUp(user: User, password: String, onSuccess: (String) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.signUp(user, password).onSuccess { userId ->
                onSuccess(userId)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun signIn(email: String, password: String, onSuccess: (String) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.signIn(email, password).onSuccess { userId ->
                onSuccess(userId)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getUser(userId: String, onSuccess: (User) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getUser(userId).onSuccess { user ->
                onSuccess(user)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun updateUser(user: User, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.updateUser(user).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun addCustomer(user: User, password: String, onSuccess: (String) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.addCustomer(user, password).onSuccess { userId ->
                onSuccess(userId)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun deleteUser(userId: String, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.deleteUser(userId).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getAllUsers(onSuccess: (List<User>) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getAllUsers().onSuccess { users ->
                onSuccess(users)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    // Order-related functions
    fun createOrder(order: Order, onSuccess: (String) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.createOrder(order).onSuccess { orderId ->
                onSuccess(orderId)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getOrder(orderId: String, onSuccess: (Order) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getOrder(orderId).onSuccess { order ->
                onSuccess(order)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun updateOrderStatus(orderId: String, newStatus: String, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.updateOrderStatus(orderId, newStatus).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun updateOrder(order: Order, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.updateOrder(order).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun deleteOrder(orderId: String, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.deleteOrder(orderId).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getAllOrders(onSuccess: (List<Order>) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getAllOrders().onSuccess { orders ->
                onSuccess(orders)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getAllTodayOrders(onSuccess: (List<Order>) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getAllTodayOrders().onSuccess { todayOrders ->
                onSuccess(todayOrders)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    // Bill-related functions
    fun createBill(bill: Bill, onSuccess: (String) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.createBill(bill).onSuccess { billId ->
                onSuccess(billId)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun markBillAsPaid(billId: String, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.markBillAsPaid(billId).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun updateBill(bill: Bill, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.updateBill(bill).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getBill(billId: String, onSuccess: (Bill) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getBill(billId).onSuccess { bill ->
                onSuccess(bill)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getAllBills(onSuccess: (List<Bill>) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getAllBills().onSuccess { bills ->
                onSuccess(bills)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun recordPayment(payment: Payment, onSuccess: (String) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.recordPayment(payment).onSuccess { paymentId ->
                onSuccess(paymentId)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun getAllPayments(onSuccess: (List<Payment>) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getAllPayments().onSuccess { payments ->
                onSuccess(payments)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    // Analytics-related functions
    fun getAnalytics(analyticsId: String, onSuccess: (Analytics) -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.getAnalytics(analyticsId).onSuccess { analytics ->
                onSuccess(analytics)
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun updateAnalytics(analytics: Analytics, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.updateAnalytics(analytics).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    // Canes-related functions
    fun updateCanesReturned(userId: String, canesReturned: Int, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.updateCanesReturned(userId, canesReturned).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }

    fun updateCanesTaken(userId: String, canesTaken: Int, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            repository.updateCanesTaken(userId, canesTaken).onSuccess {
                onSuccess()
            }.onFailure { exception ->
                onFailure(exception)
            }
        }
    }
}