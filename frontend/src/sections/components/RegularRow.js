import React from "react";
import { Box, Button } from "@material-ui/core";

const ButtonRow = (props) => {
    
    const array = ["+", "-", "*", "÷"];
    
    return (
        <Box>
            {props.buttonProps.map((buttonProp, i) => {
                return !array.includes(buttonProp) ? (
                    <span key={i}>
                        {buttonProp === "del" ? (
                            <Button
                                key={i}
                                onClick={() => {
                                    props.deleteOne();
                                }}
                                variant="contained"
                                color="primary"
                                className={props.classes.orangeButton}
                            >
                                {buttonProp}
                            </Button>
                        ) : (
                            <Button
                                key={i}
                                onClick={() => {
                                    props.clickedNumber(buttonProp);
                                }}
                                variant="contained"
                                color="primary"
                                className={props.classes.greenCyanButton}
                            >
                                {buttonProp}
                            </Button>
                        )}
                    </span>
                ) : (
                    <Button
                        key={i}
                        onClick={() => {
                            props.clickedOperator(buttonProp);
                        }}
                        variant="contained"
                        color="primary"
                        className={props.classes.greenCyanButton}
                    >
                        {buttonProp}
                    </Button>
                )
            })}
        </Box>
    );
};

export default ButtonRow;