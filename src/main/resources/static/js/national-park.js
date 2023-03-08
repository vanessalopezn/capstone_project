const PARK_REQUIRED = "Please select national park";
const STATE_REQUIRED = "Please select state";
const START_DATE = "Please select start date";
const END_DATE = "Please select end date";
const EARLIER_THAN_TODAY = "Please select another date, earlier than today";
const EQUALS_LATER_THAN_SD = "Please select another date, equals or later than start date";

const hasValueVisitFields = () =>{
    let valid = 1;

    $c("err-state");
     if( $("dropDownListStates").value == 0){
        $("err-state").innerText = STATE_REQUIRED;
        valid = 0;
     }

    $c("err-visit");
    if( $("dropDownListNP").value == 0){
        $("err-visit").innerText = PARK_REQUIRED;
        valid = 0;
    }

    $c("err-sd");
    if( $("start-date").value == 0){
        $("err-sd").innerText = START_DATE;
        valid = 0;
    }else{
            let res = validateDates($("start-date").value);
            if(res == 0){
                $("err-sd").innerText = EARLIER_THAN_TODAY;
            }

    }

    $c("err-ed");
    if( $("end-date").value == 0){
        $("err-ed").innerText = END_DATE;
        valid = 0;
    }else{
            let res = validateDates($("end-date").value);
            if(res == 0){
                $("err-ed").innerText = EARLIER_THAN_TODAY;
            }else{
                if($("start-date").value > $("end-date").value){
                    res = 0;
                    $("err-ed").innerText = EQUALS_LATER_THAN_SD;
                }else{
                res=1;
                }
            }

            valid = res;
    }



    if(valid == 1){
        document.getElementById('form_visit').submit();
    }
}

const validateDates = (date_value) => {
    let d_now = new Date().toISOString().split('T')[0];

    if(date_value >= d_now){
        return 0;
    }

    return 1;
}

const validateEndDate = (sd, ed) => {
    let start = new Date(sd);
    let ens = new Date(ed);

    if(end.getTime() > start.getTime()){
        return 0;
    }

    return 1;

}

/*
function to get an element by id
@param element name's
*/
const $ = (element) => { return document.getElementById(element); }
/*
fucntion to clear field
@param element name's
*/
const $c = (element) => { return document.getElementById(element).innerText = ''; }