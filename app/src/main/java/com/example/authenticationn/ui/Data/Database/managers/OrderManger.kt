package com.example.authenticationn.ui.Data.Database.managers



import com.example.authenticationn.ui.Data.Database.Models.Order
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

import com.google.firebase.Timestamp
import java.util.Date

class OrderManager {
    private val db: FirebaseFirestore = Firebase.firestore
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // --- Creating a New Order ---
    suspend fun createOrder(order: Order): Result<String> {
        return try {
            val documentReference = db.collection("Orders").document()
            val orderId = documentReference.id
            order.orderId = orderId
            documentReference.set(order).await()
            Result.success(orderId)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --- Retrieving Order Details ---
    suspend fun getOrder(orderId: String): Result<Order> {
        return try {
            val document = db.collection("Orders").document(orderId).get().await()
            if (document.exists()) {
                val order = document.toObject(Order::class.java)
                Result.success(order!!)
            } else {
                Result.failure(Exception("Order not found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --- Updating Order Status ---
    suspend fun updateOrderStatus(orderId: String, newStatus: String): Result<Unit> {
        return try {
            db.collection("Orders").document(orderId).update("deliveryStatus", newStatus, "updatedAt", FieldValue.serverTimestamp()).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --- Updating order ---
    suspend fun updateOrder(order: Order): Result<Unit> {
        return try {
            db.collection("Orders").document(order.orderId!!).update(
                mapOf(
                    "orderNumber" to order.orderNumber,
                    "userID" to order.userID,
                    "deliveryAddress" to order.deliveryAddress,
                    "waterType" to order.waterType,
                    "quantity" to order.quantity,
                    "expectedDeliveryDate" to order.expectedDeliveryDate,
                    "isDelivered" to order.isDelivered,
                    "deliveryTime" to order.deliveryTime,
                    "deliveryStatus" to order.deliveryStatus,
                    "deliveryFee" to order.deliveryFee,
                    "totalAmount" to order.totalAmount,
                    "notes" to order.notes,
                    "items" to order.items,
                    "canesReturning" to order.canesReturning,
                    "updatedAt" to FieldValue.serverTimestamp()

                )
            ).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --- Deleting an Order ---
    suspend fun deleteOrder(orderId: String): Result<Unit> {
        return try {
            db.collection("Orders").document(orderId).delete().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --- Get All Order ---
    suspend fun getAllOrders(): Result<List<Order>> {
        return try {
            val querySnapshot = db.collection("Orders").get().await()
            val orders = mutableListOf<Order>()
            for (document in querySnapshot.documents) {
                val order = document.toObject(Order::class.java)
                order?.let { orders.add(it) }
            }
            Result.success(orders)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --- Get All Today Order ---

    suspend fun getAllTodayOrders(): Result<List<Order>> {
        return try {
            val today = Timestamp(Date())
            val querySnapshot = db.collection("Orders").whereEqualTo("expectedDeliveryDate", today).get().await()
            val orders = mutableListOf<Order>()
            for (document in querySnapshot.documents) {
                val order = document.toObject(Order::class.java)
                order?.let { orders.add(it) }
            }
            Result.success(orders)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}