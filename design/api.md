# RESTful API Design

---

### POST /session

Log in the system

- username
- password

---

- 200
- 400
- 409

```json
{
  "id": 123123,
  "username": "Shin",
  "avatar"  : "/default.png"
}
```

### DELETE /session

Logout the system

---

- 200
- 409

```json
{
  "id": 123123,
  "username": "Shin",
  "avatar": "/default.png"
}
```

### GET /session

Retrieve current user info 

---

- 200
- 401

```json
{
  "id": 123123,
  "username": "Shin",
  "avatar": "/default.png"
}
```

### POST /user

Register a new user

- username
- password
- *avatar*

---

- 200
- 400
- 403

```json
{
  "id": 123123,
  "username": "Shin",
  "avatar": "/default.png"
}
```

### GET /user/`:userId`

Retrieve user info according to user's id

- userId

---

- 200
- 404

```json
{
  "id": 123123,
  "username": "Shin",
  "avatar": "/default.png"
}
```

### GET /films?city=`:cityCode`

Retrieve film list according to city code

- cityCode

---

- 200
- 400

```json
{
  "total": 100,
  "count": "10",
  "films": [
    {
      "id": "filmId23123123123",
      ...
    },
    ...
  ]
}
```
### GET /films/`:filmId`

Retrieve detail infomation of a film

- filmId

---

- 200
- 404

```json
{
  "id": "filmId12313123",
  ...
}
```

### GET /films/`:filmId`/cinemas

Retrieve feasible cinemas according to a film

- filmId

---

- 200
- 400

```json
{
  "id": "cinema_id_123123123",
  ...
}
```

### GET /cinemas/`:cinemaId`

Retrieve detail information of a cinema

- cinemaId

---

- 200
- 404

```json
{
  "id": "cinema_id_123lk12312312",
  ...
}
```

### GET /cinemas/`:cinemaId`/rooms

Retrieve room list of a cinema

- cinemaId

---

- 200
- 404

```json
{
  "total": 100,
  "count": 10,
  "rooms": [
    {
      "id": "room_id_123129318239",
      ...
    },
    ...
  ]
}
```

### GET /rooms/`:roomId`/seats

Retrieve seat list of a room

- roomId

---

- 200
- 404

```json
{
  "total": 100,
  "count": 10,
  "seats": [
    {
      "id": "seat_id_123129318239",
      ...
    },
    ...
  ]
}
```

### POST /reservation

Make a film reservation

- filmId
- seatId

---

- 200
- 400
- 401
- 404

```json
{
  "id": "reservation_id_123123123",
  ...
}
```

### DELETE /reservation/`:reservationId`

Cancel reservation

- reservationId

---

- 200
- 404

```json
{
  "id": "reservation_id_123123123",
  ...
}
```

### GET /reservation

Retrieve current user's reservation list

---

- 200
- 401

```json
{
  "total": 100,
  "count": 10,
  "reservations": [
    {
      "id": "reservation_id_123129318239",
      ...
    },
    ...
  ]
}
```

### GET /reservation/`:reservationId`

Retrieve detail information of a reservation

- reservationId

---

- 200
- 401
- 403
- 404

```json
{
  "id": "reservation_id_123129318239",
  ...
}
```

