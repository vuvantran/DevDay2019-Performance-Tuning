/**
 * @fileoverview gRPC-Web generated client stub for grpc
 * @enhanceable
 * @public
 */

// GENERATED CODE -- DO NOT EDIT!



const grpc = {};
grpc.web = require('grpc-web');

const proto = {};
proto.grpc = require('./HelloService_pb.js');

/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.grpc.HelloServiceClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'binary';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

  /**
   * @private @const {?Object} The credentials to be used to connect
   *    to the server
   */
  this.credentials_ = credentials;

  /**
   * @private @const {?Object} Options for the client
   */
  this.options_ = options;
};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.grpc.HelloServicePromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'binary';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

  /**
   * @private @const {?Object} The credentials to be used to connect
   *    to the server
   */
  this.credentials_ = credentials;

  /**
   * @private @const {?Object} Options for the client
   */
  this.options_ = options;
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.grpc.HelloRequest,
 *   !proto.grpc.HelloResponse>}
 */
const methodDescriptor_HelloService_hello = new grpc.web.MethodDescriptor(
  '/grpc.HelloService/hello',
  grpc.web.MethodType.UNARY,
  proto.grpc.HelloRequest,
  proto.grpc.HelloResponse,
  /** @param {!proto.grpc.HelloRequest} request */
  function(request) {
    return request.serializeBinary();
  },
  proto.grpc.HelloResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.grpc.HelloRequest,
 *   !proto.grpc.HelloResponse>}
 */
const methodInfo_HelloService_hello = new grpc.web.AbstractClientBase.MethodInfo(
  proto.grpc.HelloResponse,
  /** @param {!proto.grpc.HelloRequest} request */
  function(request) {
    return request.serializeBinary();
  },
  proto.grpc.HelloResponse.deserializeBinary
);


/**
 * @param {!proto.grpc.HelloRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.grpc.HelloResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.grpc.HelloResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.grpc.HelloServiceClient.prototype.hello =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/grpc.HelloService/hello',
      request,
      metadata || {},
      methodDescriptor_HelloService_hello,
      callback);
};


/**
 * @param {!proto.grpc.HelloRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.grpc.HelloResponse>}
 *     A native promise that resolves to the response
 */
proto.grpc.HelloServicePromiseClient.prototype.hello =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/grpc.HelloService/hello',
      request,
      metadata || {},
      methodDescriptor_HelloService_hello);
};


module.exports = proto.grpc;

