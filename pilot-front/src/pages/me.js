import axios from "axios";
import {useEffect, useState} from "react";

axios.defaults.withCredentials = true;
axios.defaults.baseURL = "http://localhost:8080"
export default function Home() {
    const [users, setUsers] = useState({});
    const fetchUsers = async () => {
        const users = await axios.get("/member")
            .then(res => res.data);
        setUsers(users)
    }

    useEffect(() => {fetchUsers()}, []);
    console.log(users?.claims?.phone_number)
    return (
      <>
          {users && users.claims && (
              <>
                  <div>{users.email}</div>
                  <div>{users.claims.phone_number}</div>
              </>
          )}

      </>
  )
}
