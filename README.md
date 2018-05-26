# AndroidArch
[![Build Status](https://travis-ci.org/ir2pid/AndroidArch.svg?branch=master)](https://travis-ci.org/ir2pid/AndroidArch)
A proof of concept for google's architecture components which uses REST api from randomuser.me/
to fetch users and display in a master detail view

coded in a mixture of kotlin and Java uses android architecture components like
- Uses MVVM architecture with data binding
- LiveData for observable data source,
- ViewModel for Activity/Fragment lifecycle awareness
- Room for ORM
- okHttp and Retrofit for network calls
- RxJava for observing network data
- Dagger2 for dependency injection

### For unit testing, integration and UI testing respectively.
- Junit,
- Mockito and
- Espresso
