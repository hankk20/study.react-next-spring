# study.react-next-spring
### 1. [Plain Html To Next JS](https://hankk.notion.site/Plain-Html-To-Next-JS-4eccf3024dca4fc78c2c8aa8f262a57f)
### 2. [next/image](https://hankk.notion.site/next-image-ccaa7aab3db04282a9944095cdba883f)
### 3. [Data Fetching](https://hankk.notion.site/Data-Fetching-9c0dbda0b29b449996237bac81582788)
### 4. 환경변수
- next start 로 시작하면 NODE_ENV는 무조건 production으로 설정된다.
- 우선순위별로 변수가 적용되고 뒤에 로드 되는 환경변수는 앞서 로드된 환경변수를 덮어 씌워지진 않는다.  
### 5. Proxy 설정
 - next.config.js
 ```jsx
module.exports = {
  async rewrites() {
    if (process.env.NODE_ENV !== 'production') {
      return [
        {
          destination: process.env.NEXT_PUBLIC_SERVER_URL,   //http://localhost:8080/:path*
          source: "/:path*",
        },
      ];
    }
  },
  reactStrictMode: true
}
```
