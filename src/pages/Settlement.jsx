import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../services/api";
import "./Login.css";

function Settlement() {

    const { groupId } = useParams();

    const [result, setResult] = useState("");

    useEffect(() => {

        fetchSettlement();

    }, []);

    const fetchSettlement = async () => {

        try {

            const response =
                await API.get(
                    `/settlementcalculate?groupId=${groupId}`
                );

            setResult(response.data);

        } catch(error) {

            console.log(error);

        }
    };

    return (

        <div className="container">

            <div className="card">

                <h1>Settlement</h1>

                <pre>
                    {result}
                </pre>

            </div>

        </div>

    );
}

export default Settlement;