import { useState } from "react";
import { Link } from "react-router-dom";
import API from "../services/api";
import './Login.css'
import { useNavigate } from "react-router-dom";

function Login() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
const handleLogin = async () => {

    try {

        const response = await API.post(
            "/users/login",
            {
                username,
                password
            }
        );
if(response.data === "Login Failed"){

    alert("Invalid Username or Password");

}else{
        localStorage.setItem(
            "token",
            response.data
        );
localStorage.setItem(
    "username",
    username
);
        alert("Login Successful");

        console.log(response.data);
        console.log(
    localStorage.getItem("username")
);
        navigate("/dashboard")
    }
    } catch(error) {

        alert("Invalid Username or Password");

        console.log(error);

    }
};
    return (
        <div className="container">

            <div className="card">

                <h1>SplitMate</h1>
                <h3>Login</h3>

                <input
                    type="text"
                    placeholder="Enter Username"
                    onChange={(e) => setUsername(e.target.value)}
                />

                <input
                    type="password"
                    placeholder="Enter Password"
                    onChange={(e) => setPassword(e.target.value)}
                />
<button onClick={handleLogin}>
    Login
</button>
<p>
   Don't have an account?
   <Link
   to="/register"
   className="register-link"
>
   Register
</Link>
   
</p>
            </div>

        </div>
    );
}

export default Login;