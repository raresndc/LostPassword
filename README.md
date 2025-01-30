# **Adversary Password Brute Force Challenge**  

## **Task Overview**  
You have successfully breached the adversary's database and retrieved a password hash stored in the attached file. The table in the file contains the hash value corresponding to your name.  

## **Password Details**  
- The adversary's password is among the **10 million most used passwords** available in the following wordlist:  
  [Ignis-10M Wordlist](https://weakpass.com/wordlist/1935)  
- To prevent the use of rainbow tables, they apply the following transformations before hashing:  
  1. **Prefixing:** The adversary adds `"ismsap"` at the beginning of all passwords.  
  2. **Hashing:**  
     - **Step 1:** The modified password (`ismsap<password>`) is hashed using **MD5**.  
     - **Step 2:** The output from the MD5 hash is then **hashed again using SHA-256**.  

## **Your Task**  
- Implement a **Java application** to brute-force the password.  
- Your solution must be contained in **a single `.java` file**.  
- The **package name** must include **your name**.  
- The program must print the **discovered password** and the **time taken (in milliseconds)** to brute-force it.  

## **Benchmarking Requirements**  
To measure the execution time, use the following sequence:  
```java  
long tstart = System.currentTimeMillis();  
// Perform brute force  
long tfinal = System.currentTimeMillis();  
System.out.println("Duration is: " + (tfinal - tstart) + " ms");  
```
