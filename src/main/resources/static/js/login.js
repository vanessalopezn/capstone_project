        function $(element)
        {
            return document.getElementById(element);
        }

        function $(element, attribute){
            return document.getElementById(element).getAttribute(attribute);

        }


        function clearValue(element, attribute){
            console.log("clearValue()");
            document.getElementById(element).setAttribute(  attribute, " ");
        }

        function focusOut(element, attribute, value){
            console.log("focusOut()");
            if( $(element, attribute) != null && $(element, attribute) != "" ){
                document.getElementById(element).setAttribute(  attribute, value);
            }
        }

