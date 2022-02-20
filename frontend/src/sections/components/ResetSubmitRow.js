import React, { useEffect, useState } from "react";
import { Box, Button } from "@material-ui/core";

const ResetSubmitRow = (props) => {
    
    const [endpoint, setEndpoint] = useState("");

    useEffect(() => {
        props.operator === "+" ? setEndpoint("add")
        : props.operator === "-" ? setEndpoint("subtract") 
        : props.operator === "*" ? setEndpoint("multiply")
        : setEndpoint("divide");
    }, [props.operator]);

  return (
    <div>
        <Box>
            <Button
                onClick={() => {
                    props.clear("0");
                }}
                variant="contained"
                color="primary"
                className={props.classes.redButton}
            >
                ce
            </Button>
            <Button
                onClick={() => {
                    props.clickedEquals(endpoint);
                }}
                variant="contained"
                color="primary"
                className={props.classes.greenButton}
            >
                =
            </Button>
        </Box>
    </div>
  );
};

export default ResetSubmitRow;