import _ from 'lodash';
import proto from './HelloService_grpc_web_pb.js';
function component() {
    const element = document.createElement('div');
    console.log(proto);
    var cli = new proto.HelloServiceClient('http://localhost:6565');
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

    return element;
}

document.body.appendChild(component());
