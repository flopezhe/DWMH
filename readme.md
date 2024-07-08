DWMH NEW READ ME FILE
Plan Outline
## Display Controller 
- Result Class
  - If success {success message}
  - else {error message}
  - If no reservations{display message}
- Domain
  - Reservation Class
    - getLocation(){}
    - getAllReservations(){}
    - getGuest(){}
    - getDates(){}
      - LocalDate
    - getTotals(){}
      - BigDecimal
- UI
  - Select host from unique value
    - viewHostsByEmail() 
  - Or Search host from options available
    - viewAllHosts()
## Make a Reservation
- Same Result Class 
- Same UI 
  - addReservation(){}
  - viewFutureReservations(){}
    - LocalDate
  - calculateTotal(){}
    - BigDecimal
    - Local Date
- Same Reservation Class
## Edit a Reservation
- Same Result Class
- Same UI to select reservation to edit
  - updateReservation(){}
  - ONLY FUTURE LOCALDATE
    - if reservation > date.now {success}
## Cancel a Reservation
- Same Result
- Same UI
  - cancelReservation(){}
  - ONLY FUTURE LOCALDATE
- Same Reservation Class
## Testing
- test schema 
- delimiter //
- setknowngoodstate()
- end //
- Test all methods above