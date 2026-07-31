import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../services/api";
import "./Login.css";

function ViewMembers() {

    const { groupId } = useParams();

    const [members, setMembers] = useState([]);

    useEffect(() => {

        fetchMembers();

    }, []);

    const fetchMembers = async () => {

        try {

            const response =
                await API.get(
                    `/members/getgroupmembers?gId=${groupId}`
                );

            setMembers(response.data);

        } catch(error) {

            console.log(error);

        }
    };

    const deleteMember = async(id) => {

        try {

            await API.delete(
                `/members/delete?memberId=${id}`
            );

            alert("Member Deleted");

            fetchMembers();

        } catch(error) {

            console.log(error);

        }
    };

    return (

        <div className="container">

            <div className="card">

                <h1>Group Members</h1>

                {
                    members.map((member) => (

                        <div key={member.id}>

                            <h3>
                                {member.membername}
                            </h3>

                            <p>
                                {member.email}
                            </p>

                            <button
                                onClick={() =>
                                    deleteMember(member.id)
                                }
                            >
                                Delete Member
                            </button>

                            <hr />

                        </div>

                    ))
                }

            </div>

        </div>

    );
}

export default ViewMembers;