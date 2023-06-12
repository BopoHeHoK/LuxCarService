package com.test.luxcarservice.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.luxcarservice.data.storage.modelDb.AppointmentEntity
import com.test.luxcarservice.data.storage.modelDb.NotificationEntity
import com.test.luxcarservice.data.storage.modelDb.ProductEntity
import com.test.luxcarservice.data.storage.modelDb.RoleEntity
import com.test.luxcarservice.data.storage.modelDb.ServiceEntity
import com.test.luxcarservice.data.storage.modelDb.ShopCartEntity
import com.test.luxcarservice.data.storage.modelDb.UserEntity

@Database(
    version = 8,
    entities = [
        AppointmentEntity::class,
        NotificationEntity::class,
        ProductEntity::class,
        RoleEntity::class,
        ServiceEntity::class,
        ShopCartEntity::class,
        UserEntity::class,
    ],
    exportSchema = true
)
abstract class LuxCarServiceDatabase : RoomDatabase() {

    abstract fun luxCarServiceDao(): LuxCarServiceDao

    companion object {
        @Volatile
        var INSTANCE: LuxCarServiceDatabase? = null

        @Synchronized
        fun getInstance(context: Context): LuxCarServiceDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    LuxCarServiceDatabase::class.java,
                    "lux_car_service.db"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return INSTANCE as LuxCarServiceDatabase
        }
    }
}