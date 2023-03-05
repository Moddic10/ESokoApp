package com.example.esoko.data

import android.accounts.NetworkErrorException
import android.app.AuthenticationRequiredException
import android.util.Log
import com.example.esoko.data.model.LoggedInUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.math.log

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {
    val auth = FirebaseAuth.getInstance()

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            val user = LoggedInUser("uid", "Fred")
            return Result.Success(user);
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    suspend fun tryLoggingIn(
        username: String,
        password: String
    ) {
        try {

            var succeeded: Boolean = false;
            var user: FirebaseUser? = null;

            auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener() { it ->
                    if (it.isSuccessful) {
                        succeeded = true;
                        user = it.result.user!!;
                        Log.println(Log.ERROR, "Complete2", "I entered here")
//                        Log.e(Log.ASSERT, "Complete3", "Suceeded");
                        Log.i("Success", "Log in succesful")
                        val us = LoggedInUser(user?.uid.toString(), username)
                        Result.Success(us);

                    } else {
                        println("fine");
//                Log.println(Log.ERROR,"test", "Failed")
                        Log.i("Failure", "Failed to login")
                        Result.Error(IOException("Invalid credentials"));
                    }
                }


        } catch (e: NetworkErrorException) {
            Log.i("Exception", "Network Error Expection")
        } catch (e: IOException) {
            Log.i("Exception", "IO Exception")
        }
    }


}