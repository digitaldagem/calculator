import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
    displayBox: {
        backgroundColor: "#daf7f1",
        borderRadius: 3,
        color: 'black',
        fontWeight: "bold",
        height: 35,
        padding: '2%',
        width: "90%"
    },
    floatLeft: {
        float: "left"
    },
    greenButton: {
        backgroundColor: "green",
        fontWeight: "bold",
        margin: theme.spacing(1, 1, 0),
        width: "45%"
    },
    greenCyanButton: {
        backgroundColor: "#1abc9c",
        fontWeight: "bold",
        margin: theme.spacing(1, 1, 0)
    },
    link: {
        float: "right",
        color: "inherit"
    },
    orangeButton: {
        backgroundColor: "orange",
        fontWeight: "bold",
        margin: theme.spacing(1, 1, 0)
    },
    redButton: {
        backgroundColor: "red",
        fontWeight: "bold",
        margin: theme.spacing(1, 1, 0),
        width: "45%"
    },
    tableHeader: {
        background: "#1abc9c",
        color: "white",
        fontSize: "1rem",
        fontWeight: "bold"
    },
    typography: {
        fontSize: "1rem",
        fontWeight: "bold"
    }
}));

export default useStyles;