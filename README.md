# Collatz_java

# 11/13/2020 1114
Found that if I used int, I couldn't use an odd number much bigger than 100M, as the number would eventually exceed the bounds of what int will allow. Decided to use long instead.  Allows a much larger number to be used. 

# 1507
Will still be limited on array size, but realistically, over 2 billion entries should be plenty of runnable numbers.

# 2301 
Everything is working in the file.  Able to run with 5000 and 30 threads.  For some reason, after 8 threads, system does not always exit out of the program.  Not sure if this is an issue with Windows, a bug in the code, or because my computer doesn't actually have that many cores. The software does run all the way through, it just doesn't return me to a command prompt. Switch back to int for the software from 1114. Only need a long for the calculation, which is not what gets fed into the arguments.