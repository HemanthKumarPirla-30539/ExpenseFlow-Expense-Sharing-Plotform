import "./Login.css";
import { Link } from "react-router-dom";
import { useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";


function Register() {
    const navigate = useNavigate();
const [name,setName]=useState("");
const [username,setUsername]=useState("");
const [email,setEmail]=useState("");
const [password,setPassword]=useState("");

const handleRegister = async () => {

    try {

        const response = await API.post(
            "/users/register",
            {
                name,
                username,
                email,
                password
            }
        );

        alert("Registration Successful");
        navigate("/")
        console.log(response.data);

    } catch(error){

        alert("Registration Failed");

        console.log(error);

    }

};
    return (
        <div className="container">

            <div className="card">

                <h1>SplitMate</h1>
                <h3>Create Account</h3>

                <input
                    type="text"
                    placeholder="Enter Name"
                     onChange={(e)=>setName(e.target.value)}
                />

                <input
                    type="text"
                    placeholder="Enter Username"
                     onChange={(e)=>setUsername(e.target.value)}
                />

                <input
                    type="email"
                    placeholder="Enter Email"
onChange={(e)=>setEmail(e.target.value)}                />

                <input
                    type="password"
                    placeholder="Enter Password"
                     onChange={(e)=>setPassword(e.target.value)}
                />

                <button onClick={handleRegister}>
    Register
</button>

                <p>
                    Already have an account?
                    <Link  to="/"
   className="register-link" >
   Login
</Link>
                </p>

            </div>

        </div>
    );
}

export default Register;