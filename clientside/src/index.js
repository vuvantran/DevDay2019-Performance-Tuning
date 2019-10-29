import _ from 'lodash';
import proto from './HelloService_grpc_web_pb.js';
function component() {
    const element = document.createElement('div');
    var cli = new proto.HelloServiceClient('http://localhost:9090');
    var rq = new proto.HelloRequest();
    rq.setFirstname('Caterina');
    rq.setLastname('Frohling');
    var call = cli.hello(rq, {}, function(err, res){
        if (err) {
            console.log(err);
        } else {
            console.log(res.getGreeting());
        }
    });
    call.on('status', function(status) {
        console.log(status);
    });

    element.innerHTML = _.join(['Hello', 'webpack'], ' ');

    /*
    fetch(
        "http://localhost:8080/library-core/api/books/search",
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: '{"keyword":"head first design"}'
        }
    ).then(rs => rs.json())
    .then(rs => {
        console.log(rs);
    }).catch(error => {
        console.log(error);
    });
    */

    return element;
}

document.body.appendChild(component());
