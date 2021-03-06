# AndroidArch
[![Build Status](https://travis-ci.org/ir2pid/AndroidArch.svg?branch=master)](https://travis-ci.org/ir2pid/AndroidArch)
[![codecov](https://codecov.io/gh/ir2pid/AndroidArch/branch/master/graph/badge.svg)](https://codecov.io/gh/ir2pid/AndroidArch)
[![codebeat badge](https://codebeat.co/badges/68d49e3e-f69b-4b7f-b2ef-677ee44eb879)](https://codebeat.co/projects/github-com-ir2pid-androidarch-master)
</br>

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
