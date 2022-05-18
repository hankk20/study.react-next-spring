import Link from "next/link";
import axios from "axios";

export default function Home() {
    axios.get("http://localhost:8080/member")
        .then((res) => {
            console.log(res);
        })
  return (
      <>
        <div>Member</div>
      </>
  )
}
