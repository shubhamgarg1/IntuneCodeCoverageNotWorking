package com.example.intunesample

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(Application::class)
interface ARHiltTestApplication

class ARRunner : AndroidJUnitRunner()
{
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?,
    ): Application
    {
        return super.newApplication(cl, ARHiltTestApplication_Application::class.java.name, context)
    }
}