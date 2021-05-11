from Sheet import Sheet

if __name__ == "__main__":
  s = Sheet(5, 5)
  print()

  s.set('A1', '2')
  s.set('A2', '5')
  s.set('A3', 'A1+A2')
  s.print()
  print()
  s.evaluate('A3')

  s.set('A1', '4')
  s.set('A4', 'A1+A3')
  s.print()
  print()

  try:
    s.set('A1', 'A3')
  except RuntimeError as e:
    print("Caught exception:", e)
  s.print()
  print()
