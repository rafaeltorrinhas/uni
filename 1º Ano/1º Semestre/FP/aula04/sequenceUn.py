def factorial(n):
   assert isinstance(n, int), "n should be an int"
   assert n >= 0            , "n should not be negative"
   # Complete aqui
   for a in range(n):
      while a>0:
         a *= n