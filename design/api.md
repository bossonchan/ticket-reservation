# RESTful API Design

---

## Login - `POST /session`

- username
- password

---

- 200
- 400
- 409

---

## Logout - `DELETE /session`

---

Nothing

---

- 200
- 409

---

## Retrieve current user info - `GET /session`

---

Nothing

---

- 200
- 401

---

## Register - `POST /user`

---

- username
- password
- *avatar*

---

- 200
- 400
- 403

---

## Retrieve user info - `GET /user/{userId}`

---

- userId

---

- 200
- 404

---

## Retrieve film list according to city code - `GET /films?city={cityCode}`

---

- cityCode

---

- 200
- 400

---

## Retrieve detail infomation of a film - `GET /films/{filmId}`

--- 

- filmId

---

- 200
- 404

---

## Retrieve feasible cinemas according to a film - `GET /films/{filmId}/cinemas`

--- 

- filmId

---

- 200
- 400

---

## Retrieve detail information of a cinema - `GET /cinemas/{cinemaId}`

---

- cinemaId

---

- 200
- 404

---

## Retrieve room list of a cinema - `GET /cinemas/{cinemaId}/rooms`

---

- cinemaId

---

- 200
- 404

---

## Retrieve seat list of a room - `GET /rooms/{roomId}/seats`

---

- roomId

---

- 200
- 404

---

## Make a film reservation - `POST /reservation`

---

- filmId
- seatId

---

- 200
- 400
- 401
- 404

---

## Cancel reservation - `DELETE /reservation/{reservationId}`

---

- reservationId

---

- 200
- 404

---

## Retrieve current user's reservation list - `GET /reservation`

---

Nothing

---

- 200
- 401

---

##  Retrieve detail information of a reservation - `GET /reservation/{reservationId}`

---

Nothing

---

- 200
- 401
- 403
- 404

---
