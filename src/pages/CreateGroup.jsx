import { useState } from "react";
import API from "../services/api";

function CreateGroup() {

    const [groupname, setGroupname] = useState("");

    const handleCreateGroup = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const username =
                localStorage.getItem("username");

            const response =
                await API.post(
                    "/groups/create",
                    {
                        groupname,
                        username
                    },
                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            alert("Group Created Successfully");

            console.log(response.data);

        } catch(error) {

            alert("Failed To Create Group");

            console.log(error);

        }
    };

    return (

        <div className="container">

            <div className="card">

                <h1>Create Group</h1>

                <input
                    type="text"
                    placeholder="Enter Group Name"
                    onChange={(e) =>
                        setGroupname(
                            e.target.value
                        )
                    }
                />

                <button
                    onClick={handleCreateGroup}
                >
                    Create Group
                </button>

            </div>

        </div>

    );
}

export default CreateGroup;