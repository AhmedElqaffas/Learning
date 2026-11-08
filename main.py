from fastapi import FastAPI, Response, Request
from fastapi.responses import FileResponse

app = FastAPI()


@app.get("/hello")
async def root():
    return FileResponse("./img.png", 
                        media_type="image/png",
                        headers={"Cache-Control": "public, max-age=60"})

@app.get("/hello_tagged")
async def root(request: Request):
    ETAG = '"12345678901"' # should be a hash of the file contents in a real application
    headers = {"Cache-Control": "private, max-age=60", # 1 minute age for demonstration purposes
                                 "ETag": ETAG}
    if request.headers.get("if-none-match") == ETAG: 
        # ETag matches, return 304 Not Modified
        return Response(status_code=304, headers=headers)
    return FileResponse("./img.png", 
                        media_type="image/png",
                        headers=headers)