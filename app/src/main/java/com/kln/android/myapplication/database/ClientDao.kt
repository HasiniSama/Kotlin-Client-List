package com.kln.android.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kln.android.myapplication.model.Client

@Dao
interface ClientDao {

    @Query("SELECT * FROM clients")
    fun getAll(): List<Client>

    @Insert
    fun add(client: Client)

    @Delete
    fun remove(client: Client)

}