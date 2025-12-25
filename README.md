# Redis Caching
A demo for caching 3rd party API responses using redis.

## How it Works
When a request is received to fetch a todo with ID,
the backend tries to looks for the todo in redis. 
In case of cache miss, the todo is fetched from https://dummyjson.com/todos
and cached to redis with a 15 seconds TTL.<br>
**Note:** when calling the 3rd party API, an extra 3 seconds sleep is added to simulate
network delay.

## Try it out
1. Open a bash terminal and build the spring boot backend
```bash
cd backend
./gradlew build
```
2. Start docker containers
```bash
docker compose up --build
```
3. Send a request to localhost:8080/<todo_id>. Example:
```curl
curl localhost:8080/2
```
- Notice how first request takes ~= 3 seconds, but subsequent requests are instant.
This is because the requested todo is cached.
4. Wait for 15 seconds and resend the request, the response will take
~= 3 seconds because the cached todo has expired.